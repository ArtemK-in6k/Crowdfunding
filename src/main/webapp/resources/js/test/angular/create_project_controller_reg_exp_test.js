describe('Testing create project controller reg exp', function() {
    var $scope, ctrl, $timeout;

    beforeEach(function (){

        module('crowdfundingApp.projects');

        module(function ($provide) {
            $provide.value('$uibModalInstance', jasmine.createSpy());
        });

        inject(function($rootScope, $controller, $q, _$timeout_) {
            $scope = $rootScope.$new();
            $timeout = _$timeout_;
            ctrl = $controller('CreateProjectController', {
                $scope: $scope,
            });
        });
    });

    it('should accept checks for correct url', function() {
        var regexp = ctrl.projectExternalUrlRegExp;
        var url = "http://boardgame.com.ua/virtuemart?page=shop.product_details&category_id=28&flypage=flypage.tpl&product_id=480";
        var res = regexp.test(url)
        expect(res).toEqual(true);
    });

    it('should not accept empty url', function() {
        var regexp = ctrl.projectExternalUrlRegExp;
        var url = "";
        var res = regexp.test(url)
        expect(res).toEqual(false);
    });
});
