//
//  HomeContainerView.swift
//  ios
//
//  Created by Tam Nguyen on 10/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct HomeContainerView: View {

    var body: some View {
        ZStack {
            VStack {
                let homeHeaderUiModel = HomeHeaderUiModel(
                    imageUrl: "https://avatars.githubusercontent.com/u/7391673?s=200&v=4",
                    dateText: "Monday, June 15",
                    todayText: "Today"
                )
                HomeHeaderView(homeHeader: homeHeaderUiModel) {
                    // TODO: Tap profile image
                    print("Tap profile image")
                }
                Spacer()
            }
        }
    }
}

#Preview {
    HomeContainerView()
}
