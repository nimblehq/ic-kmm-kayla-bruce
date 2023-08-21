//
//  SurveyItemView.swift
//  ios
//
//  Created by Tam Nguyen on 18/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct SurveyItemView: View {
    @State private var currentPage: Int = 0

    var body: some View {
        ZStack {
            GeometryReader { geometry in
                Image.url("https://picsum.photos/375/812")
                    .resizable()
                    .aspectRatio(contentMode: .fill)
                    .frame(width: geometry.size.width, height: geometry.size.height)
            }
            .ignoresSafeArea()

            GeometryReader { geometry in
                VStack(
                    alignment: .leading,
                    content: {
                        Spacer()
                        PageControl(
                            currentPage: $currentPage,
                            numberOfPages: 4
                        )
                        .frame(width: 15.0 * CGFloat(4), height: 44.0)

                        Text("Career training and development")
                            .font(.boldTitle)
                            .lineLimit(2)

                        HStack {
                            Text("We would like to know what are your goals and skills you wanted...")
                                .font(.regularXmedium)
                                .lineLimit(2)
                            Button {
                                print("Survey details")
                            } label: {
                                assets.detailButton.image
                                    .resizable()
                                    .frame(width: 56.0, height: 56.0)
                            }
                        }

                    }
                )
                .padding(
                    EdgeInsets(
                        top: 0.0,
                        leading: 20.0,
                        bottom: 0.0,
                        trailing: 20.0
                    )
                )
            }
        }
    }
}

#Preview(
    "SurveyItemView",
    traits: .fixedLayout(
        width: PreviewDimens.mediumWidth,
        height: PreviewDimens.mediumHeight
    )
) {
    SurveyItemView()
}
