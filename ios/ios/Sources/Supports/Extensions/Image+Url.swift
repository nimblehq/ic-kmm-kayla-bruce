//
//  Image+Url.swift
//  ios
//
//  Created by Tam Nguyen on 10/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Kingfisher
import SwiftUI

extension Image {

    static func url(_ imagePath: String) -> KFImage {
        return KFImage(imagePath.asURL)
    }
}
