//
//  SkeletonBox.swift
//  ios
//
//  Created by Tam Nguyen on 22/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import SkeletonUI

struct SkeletonBox: View {

    let width: CGFloat
    let height: CGFloat
    var shapeType: ShapeType

    var body: some View {
        Text(nil)
            .skeleton(
                with: true,
                size: CGSize(
                    width: width,
                    height: height
                )
            )
            .shape(type: shapeType)
            .appearance(type: .solid(color: Colors.white90, background: Colors.white50))
            .animation(type: .linear())
    }
}
