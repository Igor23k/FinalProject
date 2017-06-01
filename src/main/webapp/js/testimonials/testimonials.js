function preparationTestimonials() {
    $.ajax({
        type: 'GET',
        url: '/servlet?&rights=4&localePage=contentTestimonials&locale=' + locale,
        success: function(data) {
            alert(locale);
            setData(data['local']);
        }
    });
}