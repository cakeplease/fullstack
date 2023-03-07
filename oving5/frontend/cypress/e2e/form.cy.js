describe('template spec', () => {
  it('passes', () => {
    cy.visit('localhost:5173/form')
    cy.contains('h1', 'Form!')
    cy.get('.name').type('test');
    cy.get('.email').type('test@test.no');
    cy.get('.message').type('test!');

    cy.get('form').submit();

    cy.get('#response').contains("Takk for din tilbakemelding");
  })

  /*it('fails', () => {
    cy.visit('localhost:5173/form')
    cy.get('.email').type('test@test.no');
    cy.get('.message').type('test!');

    cy.get('form').submit();

  })*/
})