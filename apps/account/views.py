from django.shortcuts import render
from django.views.generic import View, ListView, CreateView, UpdateView
from django.http import HttpResponseRedirect
from django.utils.decorators import method_decorator
from django.contrib.auth import authenticate, login, logout
from django.views.decorators.cache import never_cache
from django.views.decorators.csrf import csrf_protect
# from apps.common.utils import LoginRequiredMixin
from django.contrib.auth.mixins import LoginRequiredMixin


# Create your views here.


class DashBoardView(LoginRequiredMixin, View):
    def get(self, request):
        return render(request, 'page/index.html')
        # return render_to_response('account/dashboard.html')


class LoginView(View):
    @method_decorator(csrf_protect)
    @method_decorator(never_cache)
    def post(self, request):
        msg = []
        username = request.POST.get('username')
        password = request.POST.get('password')
        user = authenticate(username=username, password=password)
        if user is not None:
            if user.is_active:
                login(request, user)
                return HttpResponseRedirect('/')
            else:
                msg.append('Disabled account!')
        else:
            msg.append('Password 错误！')
        return render(request, 'account/login.html', {'errors': msg})

    def get(self, request):
        if request.user.is_authenticated():
            return HttpResponseRedirect('/')
        return render(request, 'account/login.html')


class LogoutView(LoginRequiredMixin, View):
    def get(self, request):
        logout(request)
        return HttpResponseRedirect('/login')


class UserListView(LoginRequiredMixin, ListView):
    template_name = 'account/user_list.html'


class UserAddView(LoginRequiredMixin, CreateView):
    template_name = 'account/user_add.html'


class UserEditView(LoginRequiredMixin, UpdateView):
    template_name = 'account/user_edit.html'


class UserDetailView(LoginRequiredMixin, ListView):
    template_name = 'account/user_detail.html'

