# frozen_string_literal: true

class DeliverableConstants

  ##################
  #### FIREBASE ####
  ##################

  # a gsp files directory
  def self.GSP_DIRECTORY
    './'
  end

  # a gsp file name for staging
  def self.GSP_STAGING
    './ios/Configurations/Plists/Google/Staging/GoogleService-Info.plist'
  end

  # a gsp file name for production
  def self.GSP_PRODUCTION
    './ios/Configurations/Plists/Google/Production/GoogleService-Info.plist'
  end

  # a firebase app ID for Staging
  def self.FIREBASE_APP_ID_STAGING
    '1:665054598526:ios:90755ba770084b60740f2f'
  end

  # a firebase app ID for Production
  def self.FIREBASE_APP_ID_PRODUCTION
    '1:862265527597:ios:d430d009bbab3fb77a57a4'
  end

  # Firebase Tester group name, seperate by comma(,) string
  def self.FIREBASE_TESTER_GROUPS
    "nimble-dev"
  end

end
