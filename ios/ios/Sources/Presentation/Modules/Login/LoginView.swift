//
//  SignInView.swift
//  ios
//
//  Created by Thiên Nguyễn on 8/29/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct LoginView: View {

    @State private var isLoaded = false
    @State private var email = ""
    @State private var password = ""
    
    var dataSource: DataSource

    var body: some View {
        ZStack {
            R.image.bgBlur.image
                .resizable()
                .aspectRatio(contentMode: .fill)

            VStack {
                R.image.icLogowhite.image
                    .aspectRatio(contentMode: .fill)
                    .frame(maxWidth: .infinity)
                    .offset(y: isLoaded ? 0.0 : 200.0)
                    .onAppear {
                        withAnimation(.easeOut(duration: 0.5)) {
                            isLoaded.toggle()
                        }
                    }

                Spacer().frame(maxHeight: 70.0)

                if isLoaded {
                    emailField
                    Spacer().frame(maxHeight: 16.0)
                    passwordField
                    Spacer().frame(maxHeight: 20.0)
                    loginButton
                }
            }
            .padding(.horizontal, 24.0)
        }
        .ignoresSafeArea()
    }

    var emailField: some View {
        TextField(
            R.string.localizable.loginTextFieldEmail(),
            text: $email
        )
        .autocapitalization(.none)
        .disableAutocorrection(true)
        .keyboardType(.emailAddress)
        .foregroundColor(Color.white)
        .tint(Color.white.opacity(0.5))
        .padding()
        .background(Color.white.opacity(0.18))
        .cornerRadius(10.0)
        .layoutPriority(2.0)
        
    }

    var passwordField: some View {
        HStack {
            SecureField(
                R.string.localizable.loginTextFieldPassword(),
                text: $password
            )
            Button(R.string.localizable.loginButtonForgot()) {
                dataSource.coordinator.showForgotPasswordScreen()
            }
            .foregroundColor(.white.opacity(0.5))
        }
        .foregroundColor(Color.white)
        .tint(Color.white.opacity(0.5))
        .padding()
        .background(Color.white.opacity(0.18))
        .cornerRadius(10.0)
        .layoutPriority(2.0)
    }

    var loginButton: some View {
        Button(R.string.localizable.loginButtonLogin(), action: {})
            .frame(maxWidth: .infinity)
            .padding()
            .background(Color.white)
            .foregroundColor(Color.black)
            .cornerRadius(10.0)
    }
}

struct LogInView_Previews: PreviewProvider {
    
    static var previews: some View {
        LoginView(dataSource: LoginView.DataSource(coordinator: RouteCoordinator()))
    }
}
