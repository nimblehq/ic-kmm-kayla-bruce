//
//  SurveyQuestionView.swift
//  ios
//
//  Created by Tam Nguyen on 24/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct SurveyQuestionView: View {

    let id: String
    let question: Int
    @State var uiModel: SurveyQuestionUiModel

    @StateObject var dataSource: DataSource

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
        .alert(isPresented: $uiModel.isShowQuitPrompt) {
            quitAlert
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
                    uiModel.isShowQuitPrompt = true
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

    private var quitAlert: Alert {
        let yesText = Text(localized.yes)
        let cancelText = Text(localized.cancel)
            .bold()
        return Alert(
            title: Text(localized.questionQuitTitle),
            message: Text(localized.questionQuitDescription),
            primaryButton: .default(
                yesText,
                action: {
                    closeSurvey()
                }
            ),
            secondaryButton: .cancel(
                cancelText,
                action: {
                    uiModel.isShowQuitPrompt = false
                }
            )
        )
    }

    private func closeSurvey() {
        dataSource.backToHomeScreen()
    }
}

#Preview {
    let uiModel = SurveyQuestionUiModel(
        imageUrl: "https://avatars.githubusercontent.com/u/7391673?s=200&v=4",
        questionNumber: 3,
        totalQuestion: 10,
        questionTile: "How fulfilled did you feel during this WFH period?",
        isLastQuestion: false,
        isShowQuitPrompt: false
    )
    return SurveyQuestionView(
        id: .empty,
        question: 1,
        uiModel: uiModel,
        dataSource: .init(coordinator: RouteCoordinator())
    )
    .preferredColorScheme(.dark)
}

