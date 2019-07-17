package com.jeesite.modules.aa.vo;

import com.jeesite.modules.aa.entity.ExamDetail;
import com.jeesite.modules.common.entity.Exam;

public class ExamVO {

    private Exam exam;

    private ExamDetail examDetail;

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public ExamDetail getExamDetail() {
        return examDetail;
    }

    public void setExamDetail(ExamDetail examDetail) {
        this.examDetail = examDetail;
    }
}
