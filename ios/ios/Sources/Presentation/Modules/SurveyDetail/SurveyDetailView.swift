//
//  SurveyDetailView.swift
//  ios
//
//  Created by Tam Nguyen on 24/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct SurveyDetailView: View {

    let uiModel: SurveyDetailUiModel

    var body: some View {
        ZStack {
            backgroundImage
            GeometryReader { geometry in
                VStack(
                    alignment: .leading,
                    content: {
                        backButton
                        titleText
                        descriptionText
                        Spacer()
                        HStack{
                            Spacer()
                            startButton
                        }

                    }
                )
                .padding(EdgeInsets(
                    horizontal: Dimens.large,
                    vertical: geometry.safeAreaInsets.top
                ))
            }
        }
    }

    private var backgroundImage: some View {
        GeometryReader { geometry in
            Image.url(uiModel.imageUrl)
                .resizable()
                .aspectRatio(contentMode: .fill)
                .frame(width: geometry.size.width, height: geometry.size.height)
        }
        .ignoresSafeArea()
    }

    private var backButton: some View {
        Button(
            action: {
                // TODO: Navigate back
                print("Back")
            },
            label: {
                assets.icBackbutton.image
                    .resizable()
                    .frame(width: 30.0, height: 30.0)
            }
        )
    }

    private var titleText: some View {
        Text(uiModel.title)
            .font(.boldDisplay)
            .lineLimit(2)
    }

    private var descriptionText: some View {
        Text(uiModel.description)
            .font(.regularXmedium)
    }

    private var startButton: some View {
        Button(
            action: {
                // TODO: Navigate to the question screen
                print("Question 1")
            },
            label: {
                Text(localized.surveyDetailBottomStart)
                    .frame(alignment: .center)
                    .font(.boldXmedium)
                    .padding(.horizontal, Dimens.medium)
            }
        )
        .frame(height: 56.0)
        .background(Color.white)
        .foregroundColor(Color.black)
        .cornerRadius(10.0)
        .padding([.vertical], Dimens.medium)
    }
}

#Preview {
    let uiModel = SurveyDetailUiModel(
        imageUrl: "https://avatars.githubusercontent.com/u/7391673?s=200&v=4",
        title: "Working from home Check-In",
        description: "We would like to know how you feel about our work from home (WFH) experience."
    )
    return SurveyDetailView(uiModel: uiModel)
        .preferredColorScheme(.dark)
}
