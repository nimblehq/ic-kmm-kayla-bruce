//
//  SurveyQuestionView+DataSource.swift
//  ios
//
//  Created by Tam Nguyen on 29/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

extension SurveyQuestionView {

    final class DataSource: ObservableObject {

        let coordinator: SurveyQuestionCoordinator

        init(coordinator: SurveyQuestionCoordinator) {
            self.coordinator = coordinator
        }

        func backToHomeScreen() {
            coordinator.backToHomeScreen()
        }
    }
}
