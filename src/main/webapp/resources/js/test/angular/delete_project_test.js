describe('ApproveDeleteProject', function () {
    var scope, projectService;

    beforeEach(module("crowdfundingApp.control"));

    beforeEach(
        inject(
            function ($controller, $rootScope, ControlProjectsService) {
                scope = $rootScope.$new();
                projectService = ControlProjectsService;
            }
        )
    )
    ;

    it('should be equals projects before and after remove', function () {

        var projectsBeforeRemove = [{
            "id": 15,
            "userId": 3,
            "needAmount": 2500.0,
            "aboutProject": "<p style=\"color: rgb(37, 37, 37);background-color: rgb(255, 255, 255);\">Imagine a cardanic hinge –  that turns out to be the body of a ship, that axis ends up being the mast of said ship. Three spreaders rotate around it to provide balancing space for sailors, mice, bottles, crates. The spreaders are numbered (left or right to the mast, from five to ten), and the upper deck is divided into four quarters numbered 1-4. That's the set-up for<span class=\"Apple-converted-space\"> </span></p>",
            "image": "https://cf.geekdo-images.com/images/pic1214056.jpg",
            "donate_amount": 0.0,
            "date": "26-4-2016",
            "created": 1461674104058,
            "status": "COMPLETED",
            "nameProject": "Riff Raff",
            "categoryId": 0,
            "percendDonate": 0.0,
            "fullNameUser": "tt tt",
            "simpleStatus": "Completed"
        }];
        var projectsAfterRemove = {};

        expect(projectService.isProjectDeleted(projectsBeforeRemove, projectsAfterRemove)).toBe(true);
    });
});
