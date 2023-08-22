//
//  HomeHeaderSkeletonView.swift
//  ios
//
//  Created by Tam Nguyen on 22/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import SkeletonUI

struct HomeHeaderSkeletonView: View {

    var body: some View {
        VStack(alignment: .leading) {
            Spacer().frame(height: Dimens.medium)
            SkeletonText(width: 150.0, height: .large, lines: 1)
            HStack {
                SkeletonText(width: 200.0, height: .display, lines: 1)
                Spacer()
                SkeletonBox(width: 36.0, height: 36.0, shapeType: .circle)
            }
            Spacer()
        }
        .padding([.top, .horizontal], Dimens.large)
    }
}

#Preview(
    "HomeHeaderSkeletonView",
    traits: .fixedLayout(
        width: PreviewDimens.mediumWidth,
        height: PreviewDimens.mediumHeight
    )
) {
    HomeHeaderSkeletonView()
        .preferredColorScheme(.dark)
}
