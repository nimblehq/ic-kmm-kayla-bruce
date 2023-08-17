//
//  String.swift
//  ios
//
//  Created by Tam Nguyen on 10/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation

extension String {

    var asURL: URL {
        URL(string: self) ?? URL(fileURLWithPath: "")
    }
}
