//
//  HomeHeaderUiModel.swift
//  ios
//
//  Created by Tam Nguyen on 10/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

class HomeHeaderUiModel {

    let imageUrl: String
    let dateText: String
    let todayText: String

    init(
        imageUrl: String,
        dateText: String,
        todayText: String
    ) {
        self.imageUrl = imageUrl
        self.dateText = dateText
        self.todayText = todayText
    }
}
