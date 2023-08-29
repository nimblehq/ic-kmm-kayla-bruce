//
//  AppCoodinator.swift
//  ios
//
//  Created by Tam Nguyen on 25/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import FlowStacks

struct AppCoordinator: View {

    @StateObject var coordinator = RouteCoordinator()

    var body: some View {
        Router($coordinator.routes) { screen, _ in
            switch screen {
            case .splash:
                SplashView(dataSource: .init(coordinator: coordinator))
                    .preferredColorScheme(.dark)
            case .home:
                HomeContainerView(dataSource: .init(coordinator: coordinator))
            case .surveyDetail(let id):
                // TODO: - Remove dummy data
                let uiModel = SurveyDetailUiModel(
                    imageUrl: "https://avatars.githubusercontent.com/u/7391673?s=200&v=4",
                    title: "Working from home Check-In",
                    description: "We would like to know how you feel about our work from home (WFH) experience."
                )
                SurveyDetailView(
                    id: id,
                    uiModel: uiModel,
                    dataSource: .init(coordinator: coordinator)
                )
            case .surveyQuestion(let id, let question):
                // TODO: - Remove dummy data
                let uiModel = SurveyQuestionUiModel(
                    imageUrl: "https://avatars.githubusercontent.com/u/7391673?s=200&v=4",
                    questionNumber: question,
                    totalQuestion: 10,
                    questionTile: "How fulfilled did you feel during this WFH period?",
                    isLastQuestion: false
                )
                SurveyQuestionView(id: id, question: question, uiModel: uiModel)
            }
        }
    }
}
