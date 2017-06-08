function preparationTestimonials() {
    $.ajax({
        type: 'GET',
        url: '/servlet?&localePage=contentTestimonials&locale=' + locale,
        success: function(data) {
            setData(data['local']);
        }
    });
}