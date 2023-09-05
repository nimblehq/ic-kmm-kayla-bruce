//
//  HomeContainer+DataSource.swift
//  ios
//
//  Created by Tam Nguyen on 29/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

extension HomeContainerView {

    final class DataSource: ObservableObject {

        let coordinator: HomeCoordinator

        init(coordinator: HomeCoordinator) {
            self.coordinator = coordinator
        }

        func showSurveyDetailScreen(id: String) {
            coordinator.showSurveyDetailScreen(id: id)
        }
    }
}
