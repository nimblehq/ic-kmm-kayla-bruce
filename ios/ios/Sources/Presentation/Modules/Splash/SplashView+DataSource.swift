//
//  SplashView+DataSource.swift
//  ios
//
//  Created by Tam Nguyen on 28/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

extension SplashView {

    final class DataSource: ObservableObject {

        let coordinator: SplashCoordinator

        init(coordinator: SplashCoordinator) {
            self.coordinator = coordinator
        }

        func checkShouldShowHomeScreen() {
            // TODO: - Integration task
            coordinator.showHomeScreen()
        }
    }
}
