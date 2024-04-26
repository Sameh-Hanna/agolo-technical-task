class PackagesPage {

    elements = {
      countrySelector : () => cy.get('.head-links > .country-current'),
      countryEgypt : () => cy.get('#eg'),
      countryArabEmirates : () => cy.get('#ae'),
      countryAlgeria : () => cy.get('#dz'),

      litePackageName : () => cy.get('#name-lite'),
      litePackagePrice : () => cy.get('#currency-lite > b'),
      litePackageCurrency : () => cy.get('#currency-lite > i'),

      classicPackageName : () => cy.get('#name-classic'),
      classicPackagePrice : () => cy.get('#currency-classic > b'),
      classicPackageCurrency : () => cy.get('#currency-classic > i'),
      
      premiumPackageName : () => cy.get('#name-premium'),
      premiumPackagePrice : () => cy.get('#currency-premium > b'),
      premiumPackageCurrency : () => cy.get('#currency-premium > i')
    }
  
    selectCountry(country) {
        this.elements.countrySelector().click();

        cy.get('#eg', { timeout: 15000 }).should('be.visible');
        
        if(country == 'Egypt')
        this.elements.countryEgypt().click({force: true});

        if(country == 'Arab Emirates')
        this.elements.countryArabEmirates().click({force: true});

        if(country == 'Algeria')
        this.elements.countryAlgeria().click();
    }
  
    verifyLitePackageName(litePackageName) {
        this.elements.litePackageName().should(
        "have.text",
        litePackageName
        );
    }

    verifyLitePackagePrice(litePackagePrice) {
        this.elements.litePackagePrice().should(
            "have.text",
            litePackagePrice
        );
    }

    verifyLitePackageCurrency(litePackageCurrency) {
        this.elements.litePackageCurrency().should(
            "have.text",
            litePackageCurrency
        );
    }

    verifyClassicPackageName(classicPackageName) {
        this.elements.classicPackageName().should(
            "have.text",
            classicPackageName
        );
    }
  
    verifyClassicPackagePrice(classicPackagePrice) {
        this.elements.classicPackagePrice().should(
        "have.text",
        classicPackagePrice
        );
    }
        
    verifyClassicPackageCurrency(classicPackageCurrency) {
        this.elements.classicPackageCurrency().should(
        "have.text",
        classicPackageCurrency
        );
    }

    verifyPremiumPackageName(premiumPackageName) {
        this.elements.premiumPackageName().should(
            "have.text",
            premiumPackageName
        );
    }
  
    verifyPremiumPackagePrice(premiumPackagePrice) {
        this.elements.premiumPackagePrice().should(
        "have.text",
        premiumPackagePrice
        );
    }
        
    verifyPremiumPackageCurrency(premiumPackageCurrency) {
        this.elements.premiumPackageCurrency().should(
        "have.text",
        premiumPackageCurrency
        );
    }
  
}
    
  export default PackagesPage;