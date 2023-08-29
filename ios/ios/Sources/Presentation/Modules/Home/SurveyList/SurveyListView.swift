//
//  SurveyListView.swift
//  ios
//
//  Created by Tam Nguyen on 18/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct SurveyListView: View {

    let onTap: (Int) -> Void

    var body: some View {
        surveyList
    }

    var surveyList: some View {
        ZStack {
            TabView {
                SurveyItemView(onTap: onTap)
                SurveyItemView(onTap: onTap)
                SurveyItemView(onTap: onTap)
                SurveyItemView(onTap: onTap)
            }
            .tabViewStyle(PageTabViewStyle(indexDisplayMode: .never))
        }
    }
}
