describe('ApproveDeleteProject', function () {
    var scope, donateService;

    beforeEach(module("crowdfundingApp.control"));

    beforeEach(
        inject(
            function ($controller, $rootScope, ControlDonatesService) {
                scope = $rootScope.$new();
                donateService = ControlDonatesService;
            }
        )
    );

    it('should be equals donates before and after remove', function () {

        var donateBeforeRemove = [{
            "id": 35,
            "donate": 50015.0,
            "projectName": "ttttt",
            "date": 1462353093203,
            "image": "",
            "needAmount": 55555.0,
            "author": "tt tt",
            "donateAmount": 50015.0,
            "projectId": 45
        }];

        var donateAfterRemove = {};

        expect(projectService.isDonateDeleted(donateAfterRemove, donateBeforeRemove)).toBe(false);
    });
});
