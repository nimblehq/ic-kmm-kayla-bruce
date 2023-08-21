//
//  PageControl.swift
//  ios
//
//  Created by Tam Nguyen on 21/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import UIKit

struct PageControl: UIViewRepresentable {

    @Binding var currentPage: Int
    var numberOfPages: Int

    func makeCoordinator() -> Coordinator {
        Coordinator(self)
    }

    func makeUIView(context: Context) -> UIPageControl {
        let control = UIPageControl()
        control.numberOfPages = numberOfPages
        control.addTarget(
            context.coordinator,
            action: #selector(Coordinator.updateCurrentPage(sender:)),
            for: .valueChanged
        )

        return control
    }

    func updateUIView(_ uiView: UIPageControl, context: Context) {
        uiView.currentPage = currentPage
    }
}

extension PageControl {

    class Coordinator: NSObject {

        var control: PageControl

        init(_ control: PageControl) {
            self.control = control
        }

        @objc func updateCurrentPage(sender: UIPageControl) {
            control.currentPage = sender.currentPage
        }
    }
}
