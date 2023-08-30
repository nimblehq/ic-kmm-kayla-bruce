//
//  SurveyQuestionUiModel.swift
//  ios
//
//  Created by Tam Nguyen on 24/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Observation

@Observable
class SurveyQuestionUiModel {

    let imageUrl: String
    let questionNumber: Int
    let totalQuestion: Int
    let questionTile: String
    let isLastQuestion: Bool
    var isShowQuitPrompt: Bool = false

    init(
        imageUrl: String,
        questionNumber: Int,
        totalQuestion: Int,
        questionTile: String,
        isLastQuestion: Bool,
        isShowQuitPrompt: Bool
    ) {
        self.imageUrl = imageUrl
        self.questionNumber = questionNumber
        self.totalQuestion = totalQuestion
        self.questionTile = questionTile
        self.isLastQuestion = isLastQuestion
        self.isShowQuitPrompt = isShowQuitPrompt
    }
}
