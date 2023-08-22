//
//  SkeletonBox.swift
//  ios
//
//  Created by Tam Nguyen on 22/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import SkeletonUI

enum LineHeight {

    case small
    case medium
    case large
    case display

    var height: CGFloat {
        switch self {
        case .small: Dimens.small
        case .medium: Dimens.medium
        case .large: Dimens.large
        case .display: Dimens.display
        }
    }
}

struct SkeletonText: View {

    let width: CGFloat
    let height: LineHeight
    let lines: Int

    var body: some View {
        Text(nil)
            .skeleton(
                with: true,
                size: CGSize(
                    width: width,
                    height: height.height * CGFloat(lines)
                )
            )
            .shape(type: .capsule)
            .multiline(lines: lines, scales: [1: 0.5], spacing: 6.0)
            .appearance(type: .solid(color: Colors.white90, background: Colors.white50))
            .animation(type: .linear())
    }
}

