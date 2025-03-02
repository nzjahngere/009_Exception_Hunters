Feature: UI Testing (UIS_007)
  Ensures responsiveness, consistency, and performance.

  @UI
  Scenario: UIS_007_001 (Responsiveness across devices)
    Given I load the site on different screen sizes (mobile, tablet, desktop)
    Then the layout should adapt without overlapping or cutoff elements

  @UI
  Scenario: UIS_007_002 (Broken UI elements)
    Given I am on the homepage
    When I check for images, buttons, and forms
    Then all UI elements should be displayed properly with no missing assets

  @UI
  Scenario: UIS_007_003 (Consistency of font, colors, and spacing)
    Given I have the site's style guide
    When I compare actual fonts, colors, and spacing
    Then they should match the brand guidelines

  @Performance
  Scenario: UIS_007_004 (Page load performance)
    Given I open the site
    Then it should load within acceptable time (e.g., < 3 seconds)
