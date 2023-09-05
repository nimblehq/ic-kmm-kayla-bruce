//
//  SplashView.swift
//  ios
//
//  Created by Thiên Nguyễn on 8/10/23.
//  Copyright © 2023 orgName. All rights reserved.
//
import SwiftUI

private let showLogoDelay = 0.5
private let showLogoDuration = 1.0

struct SplashView: View {

    @State private var isLoaded = false

    var dataSource: DataSource

    var body: some View {
        ZStack {
            assets.bgSplash.image
                .resizable()
                .aspectRatio(contentMode: .fill)

            assets.icLogowhite.image
                .aspectRatio(contentMode: .fill)
                .frame(maxWidth: .infinity)
                .opacity(isLoaded ? 1.0 : 0.0)
        }
        .ignoresSafeArea()
        .animation(
            .easeIn(duration: showLogoDuration).delay(showLogoDelay),
            value: isLoaded
        )
        .onAppear {
            isLoaded.toggle()
            let showNextScreenDelay = showLogoDelay + showLogoDuration
            DispatchQueue.main.asyncAfter(deadline: .now() + showNextScreenDelay) {
                dataSource.checkShouldShowHomeScreen()
            }
        }
    }
}

#Preview {
    SplashView(dataSource: SplashView.DataSource(coordinator: RouteCoordinator()))
}
