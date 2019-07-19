package com.jeesite.common.utils.word;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OfficeForPOIUtil {
    public static final String REPORT_TEMPLATE = "upload/reportTemplate1.docx";
    public static String rootPath;

    public static void downloadReport(HttpServletResponse response, String path,
                                      int examId, int dataUserId, Map<String, Object> textMap) throws InvalidFormatException {
        try {
            rootPath = path;
            String inputUrl = path + REPORT_TEMPLATE;
            //获取docx解析对象
//	        XWPFDocument document = new XWPFDocument(POIXMLDocument.openPackage(inputUrl));
            CustomXWPFDocument document = new CustomXWPFDocument(POIXMLDocument.openPackage(inputUrl));
            //解析替换文本段落对象
            replaceInPara(document, textMap);
            changeTable(document, textMap);

            //生成新的word
            String outputUrl = path + "download/" + examId + "-" + dataUserId + ".docx";
            File file = new File(outputUrl);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream stream = new FileOutputStream(file);
            document.write(stream);
            stream.close();
            if (!file.exists()) {//文件不存在
                response.setContentType("text/html;charset=utf-8");
                response.setHeader("Cache-Control", "no-cache");
                PrintWriter out = response.getWriter();
                out.print("文件不存在或已被删除!");
                out.flush();
                out.close();
            }
            FileInputStream fileIn = new FileInputStream(file);
            BufferedInputStream is = new BufferedInputStream(fileIn);
            byte[] fileBytes = new byte[1024];
            String fileName = System.currentTimeMillis() + ".docx";
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment;filename="
                    + URLEncoder.encode(fileName, "UTF-8"));
            // 输出文件流
            ServletOutputStream out;
            out = response.getOutputStream();
            int len = -1;
            while ((len = is.read(fileBytes, 0, 1024)) != -1) {
                out.write(fileBytes, 0, len);
            }
            is.close();
            out.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //文件不存在
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // 编码不支持
        } catch (IOException e) {
            e.printStackTrace();
            //IO输出流异常
        }
    }

    /**
     * 根据模板生成新word文档
     * 判断表格是需要替换还是需要插入，判断逻辑有$为替换，表格无$为插入
     *
     * @param inputUrl  模板存放地址
     * @param outPutUrl 新文档存放地址
     * @param textMap   需要替换的信息集合
     * @param tableList 需要插入的表格信息集合
     * @return 成功返回true, 失败返回false
     */
    private static boolean changWord(String inputUrl, String outputUrl,
                                     Map<String, String> textMap, List<String[]> tableList) {

//        //模板转换默认成功
        boolean changeFlag = true;
//        try {
//            //获取docx解析对象
//            XWPFDocument document = new XWPFDocument(POIXMLDocument.openPackage(inputUrl));
//            //解析替换文本段落对象
//            replaceInPara(document, textMap);
//            changeTable(document, textMap, tableList);
////            replaceInTable(document, tableList);
//            
//            //生成新的word
//            File file = new File(outputUrl);
//            FileOutputStream stream = new FileOutputStream(file);
//            document.write(stream);
//            stream.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            changeFlag = false;
//        }
//
        return changeFlag;

    }

    /**
     * 替换段落文本
     *
     * @param document docx解析对象
     * @param textMap  需要替换的信息集合
     * @throws IOException
     * @throws InvalidFormatException
     */
    public static void replaceInPara(CustomXWPFDocument document, Map<String, Object> textMap) throws InvalidFormatException, IOException {
        //获取段落集合
        List<XWPFParagraph> paragraphs = document.getParagraphs();

        for (XWPFParagraph paragraph : paragraphs) {
        	System.out.println(paragraph.getParagraphText());
            if (checkImgMatcher(paragraph.getParagraphText()).find()) {
//                System.out.println(paragraph.getParagraphText());
                replaceImgInPara(document, paragraph, textMap);
                continue;
            }
            replaceInPara(paragraph, textMap);
        }

    }

    /**
     * 替换段落中的文本
     *
     * @param doc
     * @param para
     * @param params
     * @throws InvalidFormatException
     * @throws IOException
     */
    private static void replaceImgInPara(CustomXWPFDocument doc, XWPFParagraph para, Map<String, Object> params) throws InvalidFormatException, IOException {
        List<XWPFRun> runs = para.getRuns();
        Matcher matcher;
        for (int i = 0; i < runs.size(); i++) {
            XWPFRun run = runs.get(i);
            String runText = run.toString();

            matcher = checkImgMatcher(runText);

            if (matcher.find()) {
                while ((matcher = checkMatcher(runText)).find()) {
                    runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));
                }
                //直接调用XWPFRun的setText()方法设置文本时，在底层会重新创建一个XWPFRun，把文本附加在当前文本后面，
                //所以我们不能直接设值，需要先删除当前run,然后再自己手动插入一个新的run。
                para.removeRun(i);
                if (runText.equals("null")) {
                    runText = "";
                }
                para.insertNewRun(i).setText("");
                if (runText.length() > 0) {
                    File pic = new File("E:/picture/21.jpg");
                    if (pic.exists()) {
                        FileInputStream is = new FileInputStream(pic);
                        doc.addPictureData(is, Document.PICTURE_TYPE_PNG);
                        //此处图片的宽度和高度是写死的
                        doc.createPicture(doc.getAllPictures().size() - 1, 100, 50, para);
                    }
                }
            }
        }
    }

    /**
     * 替换段落里面的变量
     *
     * @param para   要替换的段落
     * @param params 参数
     */
    private static void replaceInPara(XWPFParagraph para, Map<String, Object> params) {
        List<XWPFRun> runs;
        Matcher matcher;
        runs = para.getRuns();
        for (int i = 0; i < runs.size(); i++) {
            XWPFRun run = runs.get(i);
            String runText = run.toString();
            if (runText.contains("${") && runText.contains("}")) {

            } else {
//    		   //System.out.println(runText);
            }
            matcher = checkMatcher(runText);

            if (matcher.find()) {
                while ((matcher = checkMatcher(runText)).find()) {
                    // System.out.println(runText);
                    System.out.println(params.get(matcher.group(1)));
//    			   if(params.get(matcher.group(1))!=null){

                    String tempStr = "";
                    if (params.get(matcher.group(1)) != null) {
                        tempStr = params.get(matcher.group(1)).toString();
                    }
                    if (tempStr.indexOf("$") != -1) {
                        String finalStr = "";
                        finalStr += tempStr.subSequence(0, tempStr.indexOf('$', 0));
                        finalStr += "\\$";
                        finalStr += tempStr.substring(tempStr.indexOf('$', 0) + 1, tempStr.length());
                        runText = matcher.replaceFirst(finalStr);
                    } else {
                        runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));
                    }
//    			   }
                }
                //直接调用XWPFRun的setText()方法设置文本时，在底层会重新创建一个XWPFRun，把文本附加在当前文本后面，
                //所以我们不能直接设值，需要先删除当前run,然后再自己手动插入一个新的run。
                para.removeRun(i);
                if (runText.equals("null")) {
                    runText = "";
                }

                if (runText.indexOf("\r\n") != -1 || runText.indexOf("\n") != -1) {
                    String[] runTextTemp = runText.replaceAll("\r\n", "%&%&%").replaceAll("\n", "%&%&%").split("%&%&%");
                    //倒序输出
                    Collections.reverse(Arrays.asList(runTextTemp));
                    for (String string : runTextTemp) {
                        para.insertNewRun(i).setText(string);
                        para.insertNewRun(i).addBreak();
                    }
                } else {
                    para.insertNewRun(i).setText(runText);
                }
            }
        }
    }

    /**
     * 替换表格对象方法
     *
     * @param document  docx解析对象
     * @param textMap   需要替换的信息集合
     * @param tableList 需要插入的表格信息集合
     */
    @SuppressWarnings("unchecked")
    public static void changeTable(XWPFDocument document, Map<String, Object> textMap) {
        //获取表格对象集合
        List<XWPFTable> tables = document.getTables();
        //设置销量目标表格数据
        List<String[]> list = (List<String[]>) textMap.get("xlmbList");
//        List<String[]> list = new ArrayList<String[]>();
//    	list.add(new String[]{"迈腾", "46"});
//    	list.add(new String[]{"速腾", "35"});
//    	list.add(new String[]{"捷达", "29"});
        insertTableCell(tables.get(0), list);

        //设置汽车定价策略数据
        List<String[]> list2 = (List<String[]>) textMap.get("vehiclePriceList");
//    	List<String[]> list2 = new ArrayList<String[]>();
//    	list2.add(new String[]{"迈腾", "2.3", "车载应急救援包、行车记录仪、倒车影像、汽车隔热防爆膜、儿童安全座椅","3.5","","商业险基本保障方案",""});
//    	list2.add(new String[]{"速腾", "2.1", "车载应急救援包、行车记录仪、倒车影像、汽车隔热防爆膜、儿童安全座椅", "3.6","","",""});
//    	list2.add(new String[]{"捷达", "1.3", "车载应急救援包、行车记录仪、倒车影像、汽车隔热防爆膜、儿童安全座椅", "3.6","","",""});
        //insertTableCell(tables.get(1), list2);
//		System.out.println("list2");
        insertTableRow(tables.get(1), list2);

        //设置抽奖礼包表格数据
        List<String[]> list3 = (List<String[]>) textMap.get("giftList");
//		List<String[]> list3 = new ArrayList<String[]>();
//		list3.add(new String[]{"特等奖", "1", "气球","100","1", "100"});
//		list3.add(new String[]{"一等奖", "1", "气球2","100","1", "100"});
//		list3.add(new String[]{"二等奖", "1", "气球3","100","1", "100"});
//		list3.add(new String[]{"三等奖", "1", "气球4","100","1", "100"});
//		System.out.println("list3");
        insertTableRow(tables.get(2), list3);

        //设置抽奖礼包表格中的合计数据
        updateTableLastRow(tables.get(2), (String) textMap.get("cjlbszzj"));

        //销售奖励表格数据
        List<String[]> list4 = (List<String[]>) textMap.get("rewordList");
//		List<String[]> list4 = new ArrayList<String[]>();
//		list4.add(new String[]{"26-50","50"});
//		list4.add(new String[]{"51-70","150"});
//		list4.add(new String[]{"71-100","250"});
//		list4.add(new String[]{"100-1000","350"});
//		System.out.println("list4");
        insertTableRow(tables.get(3), list4);

        //广告策略表格数据
        List<String[]> list5 = (List<String[]>) textMap.get("adList");
//		List<String[]> list5 = new ArrayList<String[]>();
//		list5.add(new String[]{"传单","50", "1","50"});
//		list5.add(new String[]{"报纸","150", "2", "300"});
//		list5.add(new String[]{"电视","250", "3", "750"});
//		list5.add(new String[]{"微信","350", "4", "1400"});
//		System.out.println("list5");
        insertTableRow(tables.get(4), list5);
        updateTableLastRow(tables.get(4), (String) textMap.get("adTotal"));

        //活动安排表格数据
        List<String[]> list6 = (List<String[]>) textMap.get("arrangeList");
//		List<String[]> list6 = new ArrayList<String[]>();
//		list6.add(new String[]{"活动宣传","7月15日", "7月23日","通过广播、网站和传单等形式宣传本次活动","市场部"});
//		list6.add(new String[]{"活动宣传2","7月15日", "7月23日","通过广播、网站和传单等形式宣传本次活动","市场部"});
//		list6.add(new String[]{"活动宣传3","7月15日", "7月23日","通过广播、网站和传单等形式宣传本次活动","市场部"});
//		list6.add(new String[]{"活动宣传4","7月15日", "7月23日","通过广播、网站和传单等形式宣传本次活动","市场部"});
//		list6.add(new String[]{"活动宣传5","7月15日", "7月23日","通过广播、网站和传单等形式宣传本次活动","市场部"});
//		list6.add(new String[]{"活动宣传6","7月15日", "7月23日","通过广播、网站和传单等形式宣传本次活动","市场部"});
//		list6.add(new String[]{"活动宣传7","7月15日", "7月23日","通过广播、网站和传单等形式宣传本次活动","市场部"});
//		list6.add(new String[]{"活动宣传8","7月15日", "7月23日","通过广播、网站和传单等形式宣传本次活动","市场部"});
//		System.out.println("list6");
        insertTableRow(tables.get(5), list6);

        //活动流程表格数据
        List<String[]> list7 = (List<String[]>) textMap.get("flowList");
//		List<String[]> list7 = new ArrayList<String[]>();
//		list7.add(new String[]{"9:30-10:30","活动签到", "来宾签到，登记客户信息，赠送车型资料及签到礼","市场部"});
//		list7.add(new String[]{"9:30-10:30","活动签到", "来宾签到，登记客户信息，赠送车型资料及签到礼","市场部"});
//		list7.add(new String[]{"9:30-10:30","活动签到", "来宾签到，登记客户信息，赠送车型资料及签到礼","市场部"});
//		list7.add(new String[]{"9:30-10:30","活动签到", "来宾签到，登记客户信息，赠送车型资料及签到礼","市场部"});
//		list7.add(new String[]{"9:30-10:30","活动签到", "来宾签到，登记客户信息，赠送车型资料及签到礼","市场部"});
//		list7.add(new String[]{"9:30-10:30","活动签到", "来宾签到，登记客户信息，赠送车型资料及签到礼","市场部"});
//		list7.add(new String[]{"9:30-10:30","活动签到", "来宾签到，登记客户信息，赠送车型资料及签到礼","市场部"});
//		list7.add(new String[]{"9:30-10:30","活动签到", "来宾签到，登记客户信息，赠送车型资料及签到礼","市场部"});
//		System.out.println("list7");
        insertTableRow(tables.get(6), list7);

        //查勘要点表格数据
        List<String[]> list8 = (List<String[]>) textMap.get("prospectList");
//		List<String[]> list8 = new ArrayList<String[]>();
//		list8.add(new String[]{"卫生间布局", "来宾签到，登记客户信息，赠送车型资料及签到礼"});
//		list8.add(new String[]{"卫生间布局", "来宾签到，登记客户信息，赠送车型资料及签到礼"});
//		list8.add(new String[]{"卫生间布局", "来宾签到，登记客户信息，赠送车型资料及签到礼"});
//		list8.add(new String[]{"卫生间布局", "来宾签到，登记客户信息，赠送车型资料及签到礼"});
//		list8.add(new String[]{"卫生间布局", "来宾签到，登记客户信息，赠送车型资料及签到礼"});
//		list8.add(new String[]{"卫生间布局", "来宾签到，登记客户信息，赠送车型资料及签到礼"});
//		list8.add(new String[]{"卫生间布局", "来宾签到，登记客户信息，赠送车型资料及签到礼"});
//		System.out.println("list8");
        insertTableRow(tables.get(7), list8);

        //活动预算表格数据
        List<String[]> list9 = (List<String[]>) textMap.get("activityCostList");
//		List<String[]> list9 = new ArrayList<String[]>();
//		list9.add(new String[]{"礼包费用", "手机", "1500", "2", "3000"});
//		list9.add(new String[]{"礼包费用", "500代金券", "500", "1", "500"});
//		list9.add(new String[]{"宣传费用", "微博", "2000", "6", "12000"});
//		list9.add(new String[]{"宣传费用", "公众号", "1000", "2", "2000"});
//		list9.add(new String[]{"宣传费用", "广播全天套播（8次）", "1000", "5", "5000"});
//		System.out.println("list9");
        insertTableRow(tables.get(8), list9);
        updateTableLastRow(tables.get(8), (String) textMap.get("activityCostTotal"));

        //物料采购表格数据
        List<String[]> list10 = (List<String[]>) textMap.get("materialPurchaseList");
//		List<String[]> list10 = new ArrayList<String[]>();
//		list10.add(new String[]{"宣传类", "刀旗", "2", "0"});
//		list10.add(new String[]{"宣传类", "拱门", "2", "0"});
//		list10.add(new String[]{"宣传类", "拱门", "2", "0"});
//		list10.add(new String[]{"宣传类", "拱门", "2", "0"});
//		System.out.println("list10");
        insertTableRow(tables.get(9), list10);
    }

    /**
     * 为表格插入数据，行数不变，动态添加新列
     *
     * @param table  需要插入数据的表格
     * @param valMap 插入数据集合
     */
    private static void insertTableCell(XWPFTable table, List<String[]> tableList) {
        List<XWPFTableRow> rows = table.getRows();
        for (int i = 0; i < rows.size(); i++) {
            for (int j = 0; j < tableList.size(); j++) {
                XWPFTableRow newRow = table.getRow(i);
                XWPFTableCell newCell = newRow.createCell();
                newCell.setText(tableList.get(j)[i]);
            }
        }
        // 如何设置table的宽度自适应
        table.setWidth(0);
    }

    /**
     * 为表格插入数据，列数不变，动态添加新行
     *
     * @param table     表格
     * @param tableList 数据列表
     */
    private static void insertTableRow(XWPFTable table, List<String[]> tableList) {
        XWPFTableRow hearRow = table.getRow(0);
        //动态创建行
        for (int i = 0; i < tableList.size(); i++) {
            copyPro(hearRow, table.insertNewTableRow(1));
        }

        for (int i = 0; i < tableList.size(); i++) {
            XWPFTableRow newRow = table.getRow(i + 1);
            String[] valArr = tableList.get(i);
            for (int j = 0; j < valArr.length; j++) {
//        		//System.out.println(newRow);
//        		//System.out.println(newRow.getCell(j));
                newRow.getCell(j).setText(valArr[j]);
            }
        }
    }

    private static void updateTableLastRow(XWPFTable table, String val) {
        XWPFTableRow lastRow = table.getRow(table.getRows().size() - 1);
        lastRow.getCell(lastRow.getTableCells().size() - 1).setText(val);
    }

    private static void copyPro(XWPFTableRow sourceRow, XWPFTableRow targetRow) {
        //复制行属性
        targetRow.getCtRow().setTrPr(sourceRow.getCtRow().getTrPr());
        List<XWPFTableCell> cellList = sourceRow.getTableCells();
        if (null == cellList) {
            return;
        }
        //添加列、复制列以及列中段落属性
        XWPFTableCell targetCell = null;
        for (XWPFTableCell sourceCell : cellList) {
            targetCell = targetRow.addNewTableCell();
            //列属性
            targetCell.getCTTc().setTcPr(sourceCell.getCTTc().getTcPr());
            //段落属性
            targetCell.getParagraphs().get(0).getCTP().setPPr(sourceCell.getParagraphs().get(0).getCTP().getPPr());
        }
    }

    /**
     * 正则匹配字符串
     *
     * @param str
     * @return
     */
    public static Matcher checkMatcher(String str) {
        Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        ////System.out.println(matcher.toString());
        return matcher;
    }

    /**
     * 正则匹配图片
     *
     * @param str
     * @return
     */
    public static Matcher checkImgMatcher(String str) {
        //System.out.println(str);
//        Pattern pattern = Pattern.compile("\\$\\{(.+?)img\\}", Pattern.CASE_INSENSITIVE);
        Pattern pattern = Pattern.compile("(.+?)img", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }

    /**
     * 匹配传入信息集合与模板
     *
     * @param value   模板需要替换的区域
     * @param textMap 传入信息集合
     * @return 模板需要替换区域信息集合对应值
     */
    public static String changeValue(String value, Map<String, String> textMap) {
        Set<Entry<String, String>> textSets = textMap.entrySet();
        for (Entry<String, String> textSet : textSets) {
            //匹配模板与替换值 格式${key}
            String key = "${" + textSet.getKey() + "}";
            if (value.indexOf(key) != -1) {
                value = textSet.getValue();
            }
        }
        //模板未匹配到区域替换为空
        if (checkMatcher(value).find()) {
            value = "";
        }
        return value;
    }


    public static void main(String[] args) {
        //模板文件地址
        String inputUrl = "e:/20180228.docx";
        //新生产的模板文件
        String outputUrl = "e:/20180228test.doc";
//        //模板文件地址
//        String inputUrl = "e:/20180402.docx";
//        //新生产的模板文件
//        String outputUrl = "e:/20180402test.doc";

        Map<String, String> testMap = new HashMap<String, String>();
        int index = 0;
        testMap.put("hdbj", "动态内容" + index);
        index++;
        testMap.put("dcdd", "动态内容" + index);
        index++;
        testMap.put("ddly", "动态内容" + index);
        index++;
        testMap.put("dcfs", "动态内容" + index);
        index++;
        testMap.put("fsly", "动态内容" + index);
        index++;
        testMap.put("dcwt", "动态内容" + index);
        index++;
        testMap.put("swotys", "动态内容" + index);
        index++;
        testMap.put("swotls", "动态内容" + index);
        index++;
        testMap.put("swotjh", "动态内容" + index);
        index++;
        testMap.put("swotwx", "动态内容" + index);
        index++;
        testMap.put("mbcx", "动态内容" + index);
        index++;
        testMap.put("cxly", "动态内容" + index);
        index++;
        testMap.put("khzy", "动态内容" + index);
        index++;
        testMap.put("khjtsr", "动态内容" + index);
        index++;
        testMap.put("khjtrs", "动态内容" + index);
        index++;
        testMap.put("khgcyt", "动态内容" + index);
        index++;
        testMap.put("xzmbkhly", "动态内容" + index);
        index++;
        testMap.put("zdxlmbly", "动态内容" + index);
        index++;
        testMap.put("jkmb", "动态内容" + index);
        index++;
        testMap.put("zdjkmbly", "动态内容" + index);
        index++;
        testMap.put("hdzt", "动态内容" + index);
        index++;
        testMap.put("hdztly", "动态内容" + index);
        index++;
        testMap.put("hdlx", "动态内容" + index);
        index++;
        testMap.put("hdlxly", "动态内容" + index);
        index++;
        testMap.put("fqfksyqk", "动态内容" + index);
        index++;
        testMap.put("fqfkxcby", "动态内容" + index);
        index++;
        testMap.put("fqfkzysm", "动态内容" + index);
        index++;
        testMap.put("zhbtsyqk", "动态内容" + index);
        index++;
        testMap.put("zhbtxcby", "动态内容" + index);
        index++;
        testMap.put("zhbtzysm", "动态内容" + index);
        index++;
        testMap.put("cjlbszly", "动态内容" + index);
        index++;
        testMap.put("xsjljeszly", "动态内容" + index);
        index++;
        testMap.put("ggtfly", "动态内容" + index);
        index++;
        testMap.put("ggxcwabx", "动态内容" + index);
        index++;
        testMap.put("gggxkzqk", "动态内容" + index);
        index++;
        testMap.put("gggxkznr", "动态内容" + index);
        index++;
        testMap.put("gggxkzly", "动态内容" + index);
        index++;
        testMap.put("yylmqy", "动态内容" + index);
        index++;
        testMap.put("xzyylmqyly", "动态内容" + index);
        index++;
        testMap.put("tehd1zt", "动态内容" + index);
        index++;
        testMap.put("tehd1nr", "动态内容" + index);
        index++;
        testMap.put("tehd2zt", "动态内容" + index);
        index++;
        testMap.put("tehd2nr", "动态内容" + index);
        index++;
        testMap.put("tehd3zt", "动态内容" + index);
        index++;
        testMap.put("tehd3nr", "动态内容" + index);
        index++;
        testMap.put("cdckkzdd", "动态内容" + index);
        index++;
        testMap.put("yjyacdl", "动态内容" + index);
        index++;
        testMap.put("yjyamtl", "动态内容" + index);
        index++;
        testMap.put("yjyayyhdl", "动态内容" + index);
        index++;
        testMap.put("yjyaqttfl", "动态内容" + index);
        index++;

        List<String[]> testList = new ArrayList<String[]>();
        testList.add(new String[]{"1", "1AA", "1BB", "1CC"});
        testList.add(new String[]{"2", "2AA", "2BB", "2CC"});
        testList.add(new String[]{"3", "3AA", "3BB", "3CC"});
        testList.add(new String[]{"4", "4AA", "4BB", "4CC"});

        changWord(inputUrl, outputUrl, testMap, testList);
    }
}
