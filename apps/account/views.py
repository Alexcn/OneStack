from django.shortcuts import render
from django.views.generic import View
from django.http import HttpResponse
from django.utils.decorators import method_decorator
from django.contrib.auth.decorators import login_required
from django.views.decorators.cache import never_cache
from django.views.decorators.csrf import csrf_protect

# Create your views here.


class IndexView(View):
    @method_decorator(login_required)
    def get(self, request):
        pass


class LoginView(View):
    @method_decorator(csrf_protect)
    @method_decorator(never_cache)
    def post(self, request):
        pass

    def get(self, request):
        return render(request, 'account/login.html')


class LogoutView(View):
    def get(self, request):
        pass

