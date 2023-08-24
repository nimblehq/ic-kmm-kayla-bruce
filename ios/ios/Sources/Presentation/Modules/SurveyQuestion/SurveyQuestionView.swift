//
//  SurveyQuestionView.swift
//  ios
//
//  Created by Tam Nguyen on 24/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct SurveyQuestionView: View {

    let uiModel: SurveyQuestionUiModel

    var body: some View {
        ZStack {
            backgroundImage
            GeometryReader { geometry in
                VStack(
                    alignment: .leading,
                    content: {
                        closeButton
                        questionNumberText
                        titleText
                        Spacer()
                        HStack{
                            Spacer()
                            if uiModel.isLastQuestion {
                                submitButton
                            } else {
                                nextButton
                            } 
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

    private var closeButton: some View {
        HStack {
            Spacer()
            Button(
                action: {
                    // TODO: Open pop up
                    print("Close")
                },
                label: {
                    assets.icClosebutton.image
                        .resizable()
                        .frame(width: 30.0, height: 30.0)
                }
            )
        }
    }

    private var questionNumberText: some View {
        Text("\(uiModel.questionNumber)/\(uiModel.totalQuestion)")
            .font(.regularXmedium)
            .foregroundColor(Color.gray)
            .padding([.top], Dimens.large)
    }

    private var titleText: some View {
        Text(uiModel.questionTile)
            .font(.boldDisplay)
            .padding([.top], Dimens.small)
    }

    private var nextButton: some View {
        Button(
            action: {
                // TODO: Navigate to the next question
                print("Next")
            },
            label: {
                assets.icDetaibutton.image
                    .resizable()
                    .frame(width: 56.0, height: 56.0)
            }
        )
    }

    private var submitButton: some View {
        Button(
            action: {
                // TODO: Submit and show lottie
                print("Submit")
            },
            label: {
                Text(localized.questionSubmitButtonTitle)
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
    let uiModel = SurveyQuestionUiModel(
        imageUrl: "https://avatars.githubusercontent.com/u/7391673?s=200&v=4",
        questionNumber: 3,
        totalQuestion: 10,
        questionTile: "How fulfilled did you feel during this WFH period?",
        isLastQuestion: false
    )
    return SurveyQuestionView(uiModel: uiModel)
        .preferredColorScheme(.dark)
}

