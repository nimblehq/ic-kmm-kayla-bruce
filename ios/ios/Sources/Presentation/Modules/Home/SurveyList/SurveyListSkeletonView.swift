//
//  SurveyListSkeletonView.swift
//  ios
//
//  Created by Tam Nguyen on 22/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import SkeletonUI

struct SurveyListSkeletonView: View {

    var body: some View {
        GeometryReader(content: { geometry in
            VStack(
                alignment: .leading,
                spacing: Dimens.medium
            ) {
                Spacer()
                SkeletonText(
                    width: geometry.size.width - 100.0,
                    height: .large, lines: 2
                )
                SkeletonText(
                    width: geometry.size.width - 50,
                    height: .medium, lines: 2
                )
            }.padding([.horizontal, .bottom], Dimens.medium)
        })
    }
}

#Preview(
    "SurveyListSkeletonView",
    traits: .fixedLayout(
        width: PreviewDimens.mediumWidth,
        height: PreviewDimens.mediumHeight
    )
) {
    SurveyListSkeletonView()
        .preferredColorScheme(.dark)
}
