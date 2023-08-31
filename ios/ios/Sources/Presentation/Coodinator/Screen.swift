//
//  Screen.swift
//  ios
//
//  Created by Tam Nguyen on 25/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

enum Screen {
    case splash
    case login
    case home
    case surveyDetail(id: String)
    case surveyQuestion(id: String, question: Int)
}

