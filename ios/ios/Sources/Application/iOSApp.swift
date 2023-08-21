import SwiftUI
import FirebaseCore

@main
struct SurveyApp: App {
    var body: some Scene {
        WindowGroup {
            HomeContainerView()
                .preferredColorScheme(.dark)
        }
    }
}

class AppDelegate: NSObject, UIApplicationDelegate {
    func application(
        _ application: UIApplication,
        didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil
    ) -> Bool {
        FirebaseApp.configure()
        return true
    }
}
