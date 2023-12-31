# frozen_string_literal: true

class BuildManager
  def initialize(fastlane:)
    @fastlane = fastlane
  end

  def build_ad_hoc(scheme, product_name, bundle_identifier)
      @fastlane.gym(
        scheme: scheme,
        export_method: 'ad-hoc',
        export_options: {
          provisioningProfiles: {
            bundle_identifier.to_s => "match AdHoc #{bundle_identifier}"
          }
        },
        include_bitcode: false,
        output_name: product_name,
        disable_xcpretty: true
      )
    end
end
