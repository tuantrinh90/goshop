package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.QuestionAnswerResponse;
import com.goshop.app.data.model.response.common.AnswersData;
import com.goshop.app.data.model.response.common.QuestionsData;
import com.goshop.app.presentation.model.QuestionAnswerDataVM;
import com.goshop.app.presentation.model.QuestionAnswerVM;
import com.goshop.app.utils.DateFormater;
import com.goshop.app.utils.NumberFormater;

import java.util.ArrayList;
import java.util.List;

public class QuestionAnswerMapper {

    public static QuestionAnswerVM transform(QuestionAnswerResponse response) {
        String questionTotal = response.getTotalQuestions();
        String answerTotal = response.getTotalAnswers();
        List<QuestionsData> questionsDatas = response.getQuestions();
        List<QuestionAnswerDataVM> dataVMS = new ArrayList<>();
        for(QuestionsData data:questionsDatas) {
            List<AnswersData> answersDatas = data.getAnswers();
            //todo wait for api fix
            AnswersData answersData = answersDatas.get(0);
            dataVMS.add(new QuestionAnswerDataVM(answersData.getAnswer(),
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quam velit ",
                NumberFormater.formaterAnswersCounts("12"), DateFormater.formaterDDMMYYYY(answersData.getAnswerDate())));
        }
        return new QuestionAnswerVM(questionTotal, answerTotal, dataVMS);
    }

}
