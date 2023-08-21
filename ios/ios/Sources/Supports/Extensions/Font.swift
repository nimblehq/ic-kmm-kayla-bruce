//
//  Font.swift
//  ios
//
//  Created by Tam Nguyen on 11/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import RswiftResources

enum FontWeight {

    case regular
    case bold
}

enum FontSize {

    /// 11.0
    case tiny
    /// 13.0
    case small
    /// 15.0
    case medium
    /// 20.0
    case body
    /// 28.0
    case title
    /// 34.0
    case display

    var size: CGFloat {
        switch self {
        case .tiny: return 11.0
        case .small: return 13.0
        case .medium: return 15.0
        case .body: return 20.0
        case .title: return 28.0
        case .display: return 34.0
        }
    }
}

extension Font {

    // Tiny fonts

    // Small fonts
    static var boldSmall: Font { font(weight: .bold, size: .small) }

    // Medium fonts

    // Title fonts

    // Display fonts
    static var boldDisplay: Font { font(weight: .bold, size: .display) }

    private static func font(
            weight: FontWeight,
            size: FontSize
    ) -> Font {
        switch weight {
        case .regular:
            return Font.custom(
                RFontResource.neuzeitSLTStdBook,
                size: size.size
            )
        case .bold:
            return Font.custom(
                RFontResource.neuzeitSLTStdBookHeavy,
                size: size.size
            )
        }
    }
}
