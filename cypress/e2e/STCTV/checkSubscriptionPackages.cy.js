// describe('template spec', () => {
//   it('passes', () => {
//     cy.visit('https://subscribe.stctv.com/')
//   })

//   //cy.get('#name-lite')
// })

import PackagesPage from '../../pageObjects/packagesPage';

const jsonData = require("../../fixtures/testData.json");

describe('Verify STC TV Subscription Packages', () => {
  const packagesPage = new PackagesPage();

  jsonData.forEach(testData => {

    it(`Verify Subscription Packages for ${testData.country}`, () => {
      cy.visit('/');
  
      // Select Country
      packagesPage.selectCountry(testData.country);

      // Verify Lite Package Name, Price and Currency
      packagesPage.verifyLitePackageName(testData.litePackageName);
      packagesPage.verifyLitePackagePrice(testData.litePackagePrice);
      packagesPage.verifyLitePackageCurrency(testData.litePackageCurrency);

      // Verify Classic Package Name, Price and Currency
      packagesPage.verifyClassicPackageName(testData.classicPackageName);
      packagesPage.verifyClassicPackagePrice(testData.classicPackagePrice);
      packagesPage.verifyClassicPackageCurrency(testData.classicPackageCurrency);

      // Verify Premium Package Name, Price and Currency
      packagesPage.verifyPremiumPackageName(testData.premiumPackageName);
      packagesPage.verifyPremiumPackagePrice(testData.premiumPackagePrice);
      packagesPage.verifyPremiumPackageCurrency(testData.premiumPackageCurrency);
    });
  });
});