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

            VStack(
                alignment: .leading,
                content: {
                    Spacer()
                    PageControl(
                        currentPage: $currentPage,
                        numberOfPages: 4
                    )
                    .frame(
                        width: 15.0 * CGFloat(4),
                        height: 44.0
                    )

                    // TODO: Change title
                    Text("Career training and development")
                        .font(.boldTitle)
                        .lineLimit(2)

                    // TODO: Change description
                    HStack {
                        Text("We would like to know what are your goals and skills you wanted...")
                            .font(.regularXmedium)
                            .lineLimit(2)
                        Button(
                            action: {
                                // TODO: Navigate to the detail screen
                                print("Survey details")
                            },
                            label: {
                                assets.icDetaibutton.image
                                    .resizable()
                                    .frame(width: 56.0, height: 56.0)
                            }
                        )
                    }

                }
            )
            .padding(EdgeInsets(horizontal: Dimens.large, vertical: 0.0))
        }
    }
}

#Preview {
    SurveyItemView()
        .preferredColorScheme(.dark)
}
