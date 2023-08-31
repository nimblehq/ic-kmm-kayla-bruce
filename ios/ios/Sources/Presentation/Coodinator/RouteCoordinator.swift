//
//  RouteCoordinator.swift
//  ios
//
//  Created by Tam Nguyen on 28/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import FlowStacks

class RouteCoordinator: ObservableObject {

    @Published var routes: Routes<Screen> = [.root(.splash, embedInNavigationView: true)]

    private func changeRootToHomeScreen() {
        routes = [.root(.home, embedInNavigationView: true)]
    }
}

extension RouteCoordinator: BaseCoordinator {

    func goBack() {
        routes.goBack()
    }

    func goBackToRoot() {
        routes.goBackToRoot()
    }
}

extension RouteCoordinator: SplashCoordinator {

    func showLoginScreen() {
        routes.presentCover(.login, embedInNavigationView: true)
    }

    func showHomeScreen() {
        changeRootToHomeScreen()
    }
}

extension RouteCoordinator: LoginCoordinator {

    func showForgotPasswordScreen() {
        // TODO: - Integration task with forgot password screen
    }
}

extension RouteCoordinator: HomeCoordinator {

    func showSurveyDetailScreen(id: String) {
        routes.presentCover(
            .surveyDetail(id: id),
            embedInNavigationView: true
        )
    }
}

extension RouteCoordinator: SurveyDetailCoordinator, SurveyQuestionCoordinator {

    func showSurveyQuestionScreen(id: String, question: Int) {
        routes.presentCover(
            .surveyQuestion(
                id: id,
                question: question
            ),
            embedInNavigationView: true
        )
    }

    func backToHomeScreen() {
        routes.goBackToRoot()
    }
}

