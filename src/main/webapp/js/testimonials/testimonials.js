function preparationTestimonials() {
    $.ajax({
        type: 'GET',
        url: '/servlet?&rights=4&localePage=contentTestimonials&locale=' + locale,
        success: function(data) {
            setData(data['local']);
        }
    });
}