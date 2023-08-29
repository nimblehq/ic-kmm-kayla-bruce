//
//  SurveyDetailView+DataSource.swift
//  ios
//
//  Created by Tam Nguyen on 29/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import UIKit

extension SurveyDetailView {

    final class DataSource: ObservableObject {

        let coordinator: SurveyDetailCoordinator

        init(coordinator: SurveyDetailCoordinator) {
            self.coordinator = coordinator
        }

        func showSurveyQuestion(id: String, question: Int) {
            coordinator.showSurveyQuestionScreen(id: id, question: question)
        }
    }
}
