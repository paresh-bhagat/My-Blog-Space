// jquery for section hide and show on radio button

$(document).ready(function(){

    $('input[type="radio"]').click(function(){
        var inputValue = $(this).attr("value");

        if (inputValue=="all") {
            $(".box").show("slow","swing");
        }
        else
        {
            var targetBox = $("." + inputValue);
            $(".box").not(targetBox).hide("slow","swing");
            $(targetBox).show("slow","swing");
        }
        
    });

});
