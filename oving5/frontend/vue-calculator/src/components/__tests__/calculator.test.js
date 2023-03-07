import { test, expect } from 'vitest';
import { mount } from "@vue/test-utils";
import Calculator from "@/components/Calculator.vue";
import Form from "@/components/Form.vue";


test('test', () => {
    const wrapper = mount(Calculator);
    wrapper.find('.button[value="2"]').trigger('click');
    wrapper.find('.button[value="+"]').trigger('click');
    wrapper.find('.button[value="2"]').trigger('click');
    wrapper.find('.button[value="="]').trigger('click');
    expect(wrapper.find('.display').text()).toBe('4');
});


test('Form', () => {
    const form = mount(Form);
    form.setData({
        name: "test",
        email: "test@test.no",
        message: "test",
    });

    expect(form.find('#response').text()).toBe('Takk for din tilbakemelding');
    expect().toBe('test');
})