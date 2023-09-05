//
//  LoginView+DataSource.swift
//  ios
//
//  Created by Thiên Nguyễn on 8/31/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

extension LoginView {

    final class DataSource: ObservableObject {

        let coordinator: LoginCoordinator

        init(coordinator: LoginCoordinator) {
            self.coordinator = coordinator
        }
    }
}

