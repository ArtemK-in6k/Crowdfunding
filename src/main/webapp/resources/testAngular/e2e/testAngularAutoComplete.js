'use strict';

describe('search testing', function () {

    it('should return list of projects length = 1', function () {

        browser.get('http://localhost:8080/');

        var field = element(by.css('.protractor'));
        expect(field.isPresent()).toBe(true);

        field.click();
    });
});
