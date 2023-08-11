import SwiftUI

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
            HomeContainerView()
                .preferredColorScheme(.dark)
		}
	}
}
