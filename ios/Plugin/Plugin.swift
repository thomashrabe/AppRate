import Foundation
import Capacitor
import StoreKit
/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(AppRate)
public class AppRate: CAPPlugin {

    @objc func rate(_ call: CAPPluginCall) {
        print("APP RATE iOS")
        SKStoreReviewController.requestReview()
        call.resolve([
            "value": "success"
        ])
    }
}
