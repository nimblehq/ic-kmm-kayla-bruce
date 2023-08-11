//
//  HomeHeaderView.swift
//  ios
//
//  Created by Tam Nguyen on 10/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct HomeHeaderView: View {

    let homeHeader: HomeHeaderUiModel

    var onProfileImageTap: (() -> Void)?

    var body: some View {
        VStack(alignment: .leading, spacing: Dimens.tiny) {
            Text(homeHeader.dateText.uppercased())
                .font(.boldSmall)
            HStack {
                Text(homeHeader.todayText)
                    .font(.boldDisplay)
                Spacer()
                Button {
                    onProfileImageTap?()
                } label: {
                    Image.url(homeHeader.imageUrl)
                        .resizable()
                        .frame(width: 36.0, height: 36.0)
                        .cornerRadius(18.0)
                }
            }
        }
        .padding([.top, .horizontal], Dimens.large)
    }
}

#Preview(
    "HomeHeaderView",
    traits: .fixedLayout(width: PreviewDimens.mediumWidth, height: PreviewDimens.smallHeight)
) {
    HomeHeaderView(
        homeHeader: HomeHeaderUiModel(
            imageUrl: "https://avatars.githubusercontent.com/u/7391673?s=200&v=4",
            dateText: "Monday, June 15",
            todayText: "Today")
    )
}
