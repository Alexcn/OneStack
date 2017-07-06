from django.shortcuts import render
from django.views.generic import View
from django.http import HttpResponse

# Create your views here.


class LoginView(View):
    def post(self, request):
        pass

    def get(self, request):
        return render(request, 'account/login.html')


class LogoutView(View):
    def get(self, request):
        pass

