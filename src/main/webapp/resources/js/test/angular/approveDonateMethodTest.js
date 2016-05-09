describe('ApproveDonateServiceMethod', function () {
    var scope, projectDonateService, httpBackend;

    beforeEach(module("crowdfundingApp.projects"));

    beforeEach(
        inject(
            function ($controller, $rootScope, ProjectDonatesService, $httpBackend) {
                httpBackend = $httpBackend;
                scope = $rootScope.$new();
                projectDonateService = ProjectDonatesService;
            }
        )
    );
    it('should be status code result = 200', function () {
        var donateId = 12;
        var resultStatusCode;
        projectDonateService.approveDonate(donateId).then(function(result){
           resultStatusCode = result.status;
        }
        );

        httpBackend
            .when('POST', '/api/donates/' + donateId + '/approve')
            .respond(200, { success: 'true' });

        httpBackend.flush();
        expect(resultStatusCode).toBe(200);
    });

});
