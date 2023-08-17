# frozen_string_literal: true

class Constants
    #################
    #### PROJECT ####
    #################
  
    # Workspace path
    def self.WORKSPACE_PATH
      './ios.xcworkspace'
    end
  
    # Project path
    def self.PROJECT_PATH
      './ios.xcodeproj'
    end
  
    # bundle ID for Staging app
    def self.BUNDLE_ID_STAGING
      'co.nimblehq.kaylabruce.kmmic'
    end
  
    # bundle ID for Production app
    def self.BUNDLE_ID_PRODUCTION
      'co.nimblehq.kaylabruce.kmmic'
    end
  
    #################
    #### BUILDING ###
    #################
  
    # a derived data path
    def self.DERIVED_DATA_PATH
      './DerivedData'
    end
  
    # a build path
    def self.BUILD_PATH
      './Build'
    end
  
    #################
    #### TESTING ####
    #################
  
    # a device name
    def self.DEVICE
      ENV.fetch('DEVICE', 'iPhone 14')
    end
  
    # a scheme name for testing
    def self.TESTS_SCHEME
      'ios-staging'
    end
  
    # a target name for tests
    def self.TESTS_TARGET
      'iosTests'
    end
  
    # a target name for UI tests
    def self.UI_TESTS_TARGET
      'iosUITests' # TODO: Create UITests target
    end
  
    # xcov output directory path
    def self.XCOV_OUTPUT_DIRECTORY_PATH
      './fastlane/xcov_output'
    end
  
    # test output directory path
    def self.TEST_OUTPUT_DIRECTORY_PATH
      './fastlane/test_output'
    end
  
    #################
    #### KEYCHAIN ####
    #################
  
    # Keychain name
    def self.KEYCHAIN_NAME
      'github_action_keychain'
    end
  
    # Keychain password
    def self.KEYCHAIN_PASSWORD
      'password'
    end
  
    #################
    ### ARCHIVING ###
    #################
  
     # a developer portal team id
    def self.DEV_PORTAL_TEAM_ID
      '4TWS7E2EPE'
    end
  
    # an staging environment scheme name
    def self.SCHEME_NAME_STAGING
      'ios-staging'
    end
  
    # a Production environment scheme name
    def self.SCHEME_NAME_PRODUCTION
      'ios-production'
    end
  
    # an staging product name
    def self.PRODUCT_NAME_STAGING
      'Surveys Staging'
    end
  
    # a Production product name
    def self.PRODUCT_NAME_PRODUCTION
      'Surveys'
    end
  
    # a main target name
    def self.MAIN_TARGET_NAME
      'ios'
    end
  end
